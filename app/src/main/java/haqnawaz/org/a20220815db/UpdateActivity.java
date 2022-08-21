package haqnawaz.org.a20220815db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class UpdateActivity extends AppCompatActivity {

    StudentModel student;

    EditText name;
    EditText roll_number;
    Switch switchIsActive;
    Button update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_acitivity);
        Intent intent = getIntent();

        student = (StudentModel) intent.getSerializableExtra("student");
        student.setOldRollNumber(student.getRollNumber());

        name = findViewById(R.id.update_name_field);
        roll_number = findViewById(R.id.update_roll_number_field);
        switchIsActive = findViewById(R.id.update_enroll_switch);
        update_btn = findViewById(R.id.update_btn);

        name.setText(student.getName());
        roll_number.setText(String.valueOf(student.getRollNumber()));
        switchIsActive.setChecked(student.isEnroll());

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(getBaseContext());
                student.setName(name.getText().toString());
                student.setRollNmber(Integer.parseInt(roll_number.getText().toString()));
                student.setEnroll(switchIsActive.isChecked());
                dbHelper.updateStudent(student);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}