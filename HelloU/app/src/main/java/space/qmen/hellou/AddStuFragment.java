package space.qmen.hellou;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class AddStuFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner spinner_user_type;
    private Boolean isSpinnerSelected = false;

    public AddStuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_add_stu,container,false);
        spinner_user_type = (Spinner) view.findViewById(R.id.spinner_user_type);
        spinner_user_type.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(isSpinnerSelected == true) {
        Toast.makeText(AddStuFragment.this.getActivity(), "当前用户类型是 " + parent.getItemAtPosition(position).toString(),
                            Toast.LENGTH_SHORT).show();
        } else {
            isSpinnerSelected = true;
        }
//        System.out.println(parent.getItemAtPosition(position).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
