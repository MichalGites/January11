package pl.akademiakodu.january11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // filtr broadcastu
    // String w nawiasie jest zaczerpniety z listy filtrów ze StackOverflow
    // zkomentowane do 2 sposobu
//    private IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    // ciało broadcastu
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // context przychodzi wiec nie musimy odwolywac sie do activity
            Toast.makeText(context, "Przyszedł SMS!", Toast.LENGTH_LONG).show();
            // pdus slowo kluczowe pod ktorym kryje sie tresc smsa chyba
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // powiązanie filtra z ciałem - rejestracja Receivera - drugi sposób rejestracji w manifeście się robi
//        registerReceiver(broadcastReceiver, filter);
        // trzeba jeszcze zapytac uzytkownika o zgode na otwarcie smsa czyli tzw permisja na odbieranie smsow
        // permisje dodajemy w manifeśie - linijka uses permission
    }
    // przycisk wywoluje wyslanie wiadomosci (wlasnej wiadomosci) - trzeba ja jeszcze odebrac
    // czyli zmienic w manifescie Stringa ze SO na Stringa w nawiasie metody setAction
    @OnClick(R.id.send)
    public void onButtonClick(){
        Intent i = new Intent();
        i.setAction("pl.akademiakodu.akcja");
        sendBroadcast(i);
    }

}
