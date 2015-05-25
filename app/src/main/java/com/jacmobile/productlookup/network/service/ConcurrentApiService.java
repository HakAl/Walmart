package com.jacmobile.productlookup.network.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class ConcurrentApiService extends ConcurrentIntentService
{
    public static final String QUERY = "query";
    public static final String MESSENGER = "messenger";
    public static final int SUCCESSFUL = "download_successful".hashCode();
    public static final int FAILED = "download_failed".hashCode();

    public static final int MAX_CONCURRENT_DOWNLOADS = 3;
    public static final Executor DOWNLOAD_THREAD_POOL =
            Executors.newFixedThreadPool(
                    MAX_CONCURRENT_DOWNLOADS, new ThreadFactory()
                    {
                        @Override
                        public Thread newThread(Runnable r)
                        {
                            Thread t = new Thread(r);
                            Process.setThreadPriority(
                                    Process.THREAD_PRIORITY_BACKGROUND);
                            t.setName("download");
                            return t;
                        }
                    });

    @Inject WalmartService walmartService;

    @Inject public ConcurrentApiService()
    {
        super(DOWNLOAD_THREAD_POOL);
    }

    public static int searchWalmart(String query, Context ctx, Messenger messenger)
    {
        Intent intent = new Intent(ctx, ConcurrentApiService.class);
        intent.putExtra(QUERY, query);
        intent.putExtra(REQUEST_ID, QUERY.hashCode());
        intent.putExtra(MESSENGER, messenger);
        ctx.startService(intent);
        return QUERY.hashCode();
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        Messenger messenger = intent.getParcelableExtra(MESSENGER);
        String query = intent.getStringExtra(QUERY);
//
//        try {
//            walmartService.searchWalmart(query);
//
//            sendMessage(messenger, SUCCESSFUL, query.hashCode(), null);
//        } catch (IOException exc) {
//            sendMessage(messenger, FAILED, query.hashCode(), null);
//        }
    }

    private void sendMessage(Messenger messenger, int status, int requestId, Uri data)
    {
        try {
            messenger.send(Message.obtain(null, status, requestId, 0, data));
        } catch (RemoteException exc) {
            Log.e(TAG, "unable to send success message to client.");
        }
    }
}