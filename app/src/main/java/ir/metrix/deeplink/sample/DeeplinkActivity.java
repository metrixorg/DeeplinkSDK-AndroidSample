package ir.metrix.deeplink.sample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.lang.StringBuilder;

public class DeeplinkActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deeplink);

        TextView descriptionView = findViewById(R.id.description);
        descriptionView.setText("Intent URI:\n" + getIntent().getData() + "\n\nActivity Extra:\n" + bundleToMapString(getIntent().getExtras()));

        Button mainButton = findViewById(R.id.mainButton);
        mainButton.setOnClickListener( v ->
                startActivity(new Intent(DeeplinkActivity.this, MainActivity.class)));
    }

    private String bundleToMapString(Bundle bundle) {
        StringBuilder builder = new StringBuilder("{");

        for (String key: bundle.keySet()) {
            builder.append("\"").append(key).append("\": \"").append(bundle.get(key)).append("\", ");
        }
        builder.setCharAt(builder.length() - 2, '}');

        return builder.toString();
    }
}