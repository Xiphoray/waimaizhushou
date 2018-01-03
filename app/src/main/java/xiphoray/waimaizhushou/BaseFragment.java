package xiphoray.waimaizhushou;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BaseFragment extends android.support.v4.app.Fragment implements MainActivity.FragmentBackHandler {

    private ArrayList<Data> datas = null;
    private android.support.v4.app.FragmentManager fManager = null;
    private BaseFragment mContext;
    public static BaseFragment newInstance(String info) {
        Bundle args = new Bundle();
        BaseFragment fragment = new BaseFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, null);
        Toast.makeText(getContext().getApplicationContext(),getArguments().getString("info"), Toast.LENGTH_SHORT);
        if(getArguments().getString("info") == "订单"){

            fManager = getChildFragmentManager();

            datas = new ArrayList<Data>();
            for (int i = 1; i <= 20; i++) {
                Data data = new Data("订单" + i + "号", i + "宫保鸡丁");
                datas.add(data);
            }
            NewListFragment nlFragment = new NewListFragment(fManager, datas);
            android.support.v4.app.FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.fl_content, nlFragment);
            ft.commit();
        }
        TextView tvInfo = (TextView) view.findViewById(R.id.message);
        tvInfo.setText(getArguments().getString("info"));
        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
            }
        });
        mContext = BaseFragment.this;


        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onBackPressed()
    {
        return BackHandlerHelper.handleBackPress(this);
    }
}
