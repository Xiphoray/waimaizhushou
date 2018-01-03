package xiphoray.waimaizhushou;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class NewPersonFragment extends android.support.v4.app.Fragment implements AdapterView.OnItemClickListener {
    private android.support.v4.app.FragmentManager fManager;
    private ArrayList<SettingPerson> datas;

    public NewPersonFragment(android.support.v4.app.FragmentManager fManager, ArrayList<SettingPerson> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }




    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_person, container, false);
        ListView list_setting = view.findViewById(R.id.list_setting);
        TextView name = view.findViewById(R.id.name);
        ImageView logo = view.findViewById(R.id.logo);
        name.setText("xxxx");
        logo.setImageResource(R.mipmap.ic_launcher_round);
        PersonAdapter myAdapter = new PersonAdapter(datas, getActivity());
        list_setting.setAdapter(myAdapter);
        list_setting.setOnItemClickListener(this);
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        android.support.v4.app.FragmentTransaction fTransaction = fManager.beginTransaction();
        NewContentFragment ncFragment = new NewContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", datas.get(position).getNew_content());
        ncFragment.setArguments(bd);
        //加上Fragment替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}
