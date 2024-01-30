import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Request permissions
        requestPermissions();

        // TextView to display welcome message
        TextView welcomeText = findViewById(R.id.welcomeText);

        // TextView to display simulated sensor values
        TextView sensorValues = findViewById(R.id.sensorValues);

        // Button to navigate to the history page
        Button historyButton = findViewById(R.id.historyButton);

        // Display welcome message
        welcomeText.setText("Hi sir, welcome to the app. Take care and wear a mask.");

        // Simulated sensor values, replace with actual values from your hardware
        String sensorData = "CO: 250 PPM\nNO2: 30 PPM\nCO2: 400 PPM\nTemperature: 25°C\nHumidity: 50%";
        sensorValues.setText(sensorData);

        // Set click listener for the history button
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the HistoryActivity when the history button is clicked
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });
    }

    // Method to request permissions
    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Check if permissions are not granted
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE)
                    != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                    != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                // Request permissions
                ActivityCompat.requestPermissions(this,
                        new String[]{
                                Manifest.permission.ACCESS_WIFI_STATE,
                                Manifest.permission.INTERNET,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        PERMISSION_REQUEST_CODE);
            }
        }
    }

    // Method to handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Handle the result of the permission request
            // You can check if the permissions are granted here
        }
    }
}
