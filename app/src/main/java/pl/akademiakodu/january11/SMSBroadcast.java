package pl.akademiakodu.january11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Michał on 2017-01-11.
 */

public class SMSBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Akcja z naszej aplikacji!", Toast.LENGTH_SHORT).show();
    }
}
