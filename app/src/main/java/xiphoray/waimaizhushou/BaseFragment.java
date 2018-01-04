package xiphoray.waimaizhushou;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class BaseFragment extends android.support.v4.app.Fragment implements MainActivity.FragmentBackHandler {

    View view;
    public static BaseFragment newInstance(String info) {
        Bundle args = new Bundle();
        BaseFragment fragment = new BaseFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }







    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //@SuppressLint("InflateParams") View

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_base, null);
            InitChoiceLayout();
        }
        else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null)
                viewGroup.removeView(view);
            ReInitChoiceLayout();
        }

        return view;
    }

    void InitChoiceLayout(){
        android.support.v4.app.FragmentManager fManager;
        if(Objects.equals(getArguments().getString("info"), "订单")){
            ArrayList<Data> datas = new ArrayList<>();
            fManager = getChildFragmentManager();

            for (int i = 1; i <= 20; i++) {
                Data data = new Data("  订单" + i + "号", i + "宫保鸡丁");
                datas.add(data);
            }
            NewListFragment nlFragment = new NewListFragment(fManager, datas);
            android.support.v4.app.FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.fl_content, nlFragment);
            ft.commit();
        }
        else if(Objects.equals(getArguments().getString("info"), "个人中心")){

            ArrayList<SettingPerson> datas = new ArrayList<>();
            fManager = getChildFragmentManager();
            String[] settings = {"历史订单","规划设置","寻呼设置","清理内存","帮助"};
            for (int i = 1; i <= 5; i++) {
                SettingPerson data = new SettingPerson("  "+settings[i-1], i + "嘿嘿嘿");
                datas.add(data);
            }
            NewPersonFragment nlFragment = new NewPersonFragment(fManager, datas);
            android.support.v4.app.FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.fl_content, nlFragment);
            ft.commit();
        }
        TextView tvInfo = view.findViewById(R.id.message);
        tvInfo.setText(getArguments().getString("info"));

    }

    void ReInitChoiceLayout(){
        android.support.v4.app.FragmentManager fManager;
        if(Objects.equals(getArguments().getString("info"), "订单")){
            ArrayList<Data> datas = new ArrayList<>();
            fManager = getChildFragmentManager();

            for (int i = 1; i <= 20; i++) {
                Data data = new Data("  订单" + i + "号", i + "宫保鸡丁");
                datas.add(data);
            }
            NewListFragment nlFragment = new NewListFragment(fManager, datas);
            android.support.v4.app.FragmentTransaction ft = fManager.beginTransaction();
            ft.replace(R.id.fl_content, nlFragment);
            ft.commit();
        }
//        else if(Objects.equals(getArguments().getString("info"), "个人中心")){
//
//            ArrayList<SettingPerson> datas = new ArrayList<>();
//            fManager = getChildFragmentManager();
//            String[] settings = {"历史订单","规划设置","寻呼设置","清理内存","帮助"};
//            for (int i = 1; i <= 5; i++) {
//                SettingPerson data = new SettingPerson("  "+settings[i-1], i + "嘿嘿嘿");
//                datas.add(data);
//            }
//            NewPersonFragment nlFragment = new NewPersonFragment(fManager, datas);
//            android.support.v4.app.FragmentTransaction ft = fManager.beginTransaction();
//            ft.replace(R.id.fl_content, nlFragment);
//            ft.commit();
//        }
//        TextView tvInfo = view.findViewById(R.id.message);
//        tvInfo.setText(getArguments().getString("info"));

    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onBackPressed()
    {
        return BackHandlerHelper.handleBackPress(this);
    }
}
