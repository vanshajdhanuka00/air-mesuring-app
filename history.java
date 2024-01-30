import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    private static final int TOTAL_RECORDS = 96; // 24 hours * 60 minutes / 15 minutes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button backButton = findViewById(R.id.backButton);
        TableLayout historyTable = findViewById(R.id.historyTable);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // Simulated historical data, replace with your actual data
        for (int i = 0; i < TOTAL_RECORDS; i++) {
            addRowToTable(historyTable, "Time " + (i + 1), "CO2 " + i, "NO2 " + i, "CO " + i, "Temp " + i, "Humidity " + i);
        }
    }

    private void addRowToTable(TableLayout tableLayout, String time, String co2, String no2, String co, String temp, String humidity) {
        TableRow tableRow = new TableRow(this);

        addTextViewToRow(tableRow, time);
        addTextViewToRow(tableRow, co2);
        addTextViewToRow(tableRow, no2);
        addTextViewToRow(tableRow, co);
        addTextViewToRow(tableRow, temp);
        addTextViewToRow(tableRow, humidity);

        tableLayout.addView(tableRow);
    }

    private void addTextViewToRow(TableRow tableRow, String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(8, 8, 8, 8);
        textView.setText(text);
        tableRow.addView(textView);
    }
}
