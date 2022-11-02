package com.chapfla.appsensors;

// importation des librairies
import java.util.List;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * class main de l'application
 */
public class MainActivity extends AppCompatActivity {

    // initialisation des variables
    SensorManager sensorManager;
    TextView textView;

    /**
     * s'exécute lors de l'initialisation' de l'application
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        // récupère la liste de tous les sensors
        List<Sensor> list=sensorManager.getSensorList(Sensor.TYPE_ALL);

        // récupère le champ dans lequel les sensors seront affichés
        textView = (TextView) findViewById(R.id.text);

        // affiche les sensors
        for (int i = 1;i<list.size();i++) {
            textView.append("\n" + list.get(i).getName());
        }
    }
}