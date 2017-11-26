package com.strengthcentric.mmaexam.classes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ActivityUtils {
    final Activity activity;

    public ActivityUtils(Activity activity) {
        this.activity = activity;
    }

    public void sendMail() {
        try {
            openingApplicationMessage();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{Settings.EMAIL});
            intent.setClassName(Settings.PACKAGE_GMAIL, Settings.PACKAGE_GMAIL + ".ComposeActivityGmail");
            activity.startActivity(Intent.createChooser(intent, "Send mail using"));
        } catch(Exception e) {
            wentWrongMessage();
        }
    }

    public void rate() {
        openingApplicationMessage();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Settings.PLAYSTORE_MARKET));
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Settings.PLAYSTORE_URL)));
        }
    }

    public void shareResult(int score, String socialMedia) {
        openingApplicationMessage();

        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, Settings.APP_NAME);
            intent.putExtra(Intent.EXTRA_TEXT, "I just scored " +
                    score + " / " + Settings.QUESTIONS_PER_ROUND +
                    " on the " + Settings.APP_NAME +
                    "\n\nCheck it out: " + Settings.PLAYSTORE_URL);
            intent.setPackage(socialMedia);
            activity.startActivity(intent);
        } catch(Exception e) {
            wentWrongMessage();
        }
    }

    private void wentWrongMessage() {
        Toast.makeText(activity, Settings.ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
    }

    private void openingApplicationMessage() {
        Toast.makeText(activity, Settings.LOADING_MESSAGE, Toast.LENGTH_SHORT).show();
    }
}
