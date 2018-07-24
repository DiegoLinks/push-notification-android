package com.fourtime.androidpushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

public class Constants {
    public enum NotificationChannel {
        DEFAULT {
            @NonNull
            @Override
            public String getId(Context context) {
                return context.getString(R.string.notification_channel_id_default);
            }

            @NonNull
            @Override
            public String getName(Context context) {
                return context.getString(R.string.notification_channel_id_default);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public int getImportance(Context context) {
                return NotificationManager.IMPORTANCE_HIGH;
            }

            @NonNull
            @Override
            public String getDescription(Context context) {
                return context.getString(R.string.notification_channel_id_default);
            }

            @Override
            public boolean shouldShowLights(Context context) {
                return false;
            }

            @Nullable
            @Override
            public Integer getLightColor(Context context) {
                return null;
            }

            @Override
            public boolean shouldVibrate(Context context) {
                return true;
            }

            @Nullable
            @Override
            public long[] getVibrationPattern(Context context) {
                return null;
            }

            @Override
            public boolean shouldPlayAudio(Context context) {
                return true;
            }

            @Nullable
            @Override
            public Uri getAudioUri(Context context) {
                return RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Nullable
            @Override
            public AudioAttributes getAudioAttributes(Context context) {
                return new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
                        .build();
            }

            @Override
            public boolean canShowBadge(Context context) {
                return true;
            }

            @Override
            public boolean canBypassDoNotDisturbMode(Context context) {
                return false;
            }

            @Nullable
            @Override
            public String getGroup(Context context) {
                return null;
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public int getLockScreenVisibility(Context context) {
                return Notification.VISIBILITY_PUBLIC;
            }
        };

        @NonNull
        public abstract String getId(Context context);
        @NonNull
        public abstract String getName(Context context);
        @RequiresApi(api = Build.VERSION_CODES.N)
        public abstract int getImportance(Context context);
        @NonNull
        public abstract String getDescription(Context context);
        public abstract boolean shouldShowLights(Context context);
        @Nullable
        public abstract Integer getLightColor(Context context);
        public abstract boolean shouldVibrate(Context context);
        @Nullable
        public abstract long[] getVibrationPattern(Context context);
        public abstract boolean shouldPlayAudio(Context context);
        @Nullable
        public abstract Uri getAudioUri(Context context);
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Nullable
        public abstract AudioAttributes getAudioAttributes(Context context);
        public abstract boolean canShowBadge(Context context);
        public abstract boolean canBypassDoNotDisturbMode(Context context);
        @Nullable
        public abstract String getGroup(Context context);
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @NonNull
        public abstract int getLockScreenVisibility(Context context);
    }
}
