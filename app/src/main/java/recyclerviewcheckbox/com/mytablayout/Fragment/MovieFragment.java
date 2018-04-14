package recyclerviewcheckbox.com.mytablayout.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import recyclerviewcheckbox.com.mytablayout.R;

/**
 * Created by ombharti on 14-Apr-18.
 */

public class MovieFragment extends Fragment {

    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        v = inflater.inflate( R.layout.fragment_movie, container, false);


        return v;
    }


}
