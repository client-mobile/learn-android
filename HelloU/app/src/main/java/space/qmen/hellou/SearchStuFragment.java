package space.qmen.hellou;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class SearchStuFragment extends Fragment {


    public SearchStuFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_search_stu, container,false);

        return view;
    }


}