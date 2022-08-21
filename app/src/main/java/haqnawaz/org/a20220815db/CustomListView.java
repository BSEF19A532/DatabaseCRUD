package haqnawaz.org.a20220815db;

import android.app.Activity;
import android.content.Intent;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<StudentModel> {

    public CustomListView(Activity context, ArrayList<StudentModel> students) {
        super(context, 0, students);
    }

    public View getView(int position, View view, ViewGroup parent) {
        StudentModel student = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View singleElement = inflater.inflate(R.layout.custom_list_view_layout, null , true);
        ((TextView) singleElement.findViewById(R.id.student_name))
                .setText(student.getName());
        ((TextView) singleElement.findViewById(R.id.student_id))
                .setText(String.valueOf(student.getRollNumber()));
        ((TextView) singleElement.findViewById(R.id.enrolled))
                .setText( student.isEnroll() ? "Enrolled" : "Not Enrolled" );

        Button update_btn = singleElement.findViewById(R.id.student_update);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(), UpdateActivity.class);
                intent.putExtra("student", student);
                parent.getContext().startActivity(intent);
            }
        });

        Button delete_btn = singleElement.findViewById(R.id.student_delete);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(parent.getContext());
                dbHelper.deleteStudent(student.getRollNumber());
            }
        });


        return singleElement;
    }
}
