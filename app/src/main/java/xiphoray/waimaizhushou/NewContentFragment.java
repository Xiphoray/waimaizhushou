package xiphoray.waimaizhushou;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jay on 2015/9/6 0006.
 */
public class NewContentFragment extends android.support.v4.app.Fragment implements MainActivity.FragmentBackHandler {

    @SuppressLint("ValidFragment")
    NewContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        //getArgument获取传递过来的Bundle对象
        txt_content.setText(getArguments().getString("content"));
        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onBackPressed()
    {
        return BackHandlerHelper.handleBackPress(this);
    }
}
