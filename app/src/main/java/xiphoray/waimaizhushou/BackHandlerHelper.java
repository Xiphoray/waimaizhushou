package xiphoray.waimaizhushou;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.List;

public class BackHandlerHelper {

    /**
     * 将back事件分发给 FragmentManager 中管理的子Fragment，如果该 FragmentManager 中的所有Fragment都
     * 没有处理back事件，则尝试 FragmentManager.popBackStack()
     *
     * @return 如果处理了back键则返回 <b>true</b>
     * @see #handleBackPress(NewContentFragment)
     * @see #handleBackPress(MainActivity)
     * @see #handleBackPress(BaseFragment)
     * //@param fragmentManager
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static boolean handleBackPress(android.support.v4.app.FragmentManager fragmentManager) {
        List<android.support.v4.app.Fragment> fragments = fragmentManager.getFragments();

        if (fragments == null) return false;

        for (int i = fragments.size() - 1; i >= 0; i--) {
            android.support.v4.app.Fragment child = fragments.get(i);

            if (isFragmentBackHandled(child)) {
                return true;
            }
        }

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return true;
        }
        return false;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    static boolean handleBackPress(NewContentFragment fragment) {
        return handleBackPress(fragment.getChildFragmentManager());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static boolean handleBackPress(MainActivity fragmentActivity) {
        return handleBackPress(fragmentActivity.getSupportFragmentManager());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static boolean handleBackPress(BaseFragment baseFragment)
    {
        return handleBackPress(baseFragment.getChildFragmentManager());
    }

    /**
     * 判断Fragment是否处理了Back键
     *
     * @return 如果处理了back键则返回 <b>true</b>
     */
    private static boolean isFragmentBackHandled(android.support.v4.app.Fragment fragment) {
        return fragment != null
                && fragment.isVisible()
                && fragment.getUserVisibleHint() //for ViewPager
                && fragment instanceof MainActivity.FragmentBackHandler
                && ((MainActivity.FragmentBackHandler) fragment).onBackPressed();
    }


}
