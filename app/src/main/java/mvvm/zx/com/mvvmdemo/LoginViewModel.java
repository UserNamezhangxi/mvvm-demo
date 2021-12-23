package mvvm.zx.com.mvvmdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;

import mvvm.zx.com.mvvmdemo.databinding.ActivityMainBinding;

public class LoginViewModel extends AndroidViewModel {

    private final MutableLiveData<UserModel> data = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
        UserModel model = new UserModel();
        model.setUserAccount("zhangxi");
        model.setUserPassword("123");
        model.setIsShowImageBtn(true);
        model.setResultText("this is result area");
        data.setValue(model);
    }

    public MutableLiveData<UserModel> getData() {
        return data;
    }

    public TextWatcher accountTextWatcher = new SimpleTextWatcher() {
        @Override public void afterTextChanged(Editable s) {
            UserModel model = getData().getValue();
            if (model != null) {
                model.setUserAccount(s.toString());
                if (model.getUserAccount().equals("")) {
                    model.setIsShowImageBtn(false);
                } else {
                    model.setIsShowImageBtn(true);
                }
                getData().postValue(model);
            }
        }
    };

    public void doClickEvent() {
        UserModel model = getData().getValue();
        if (model != null) {
            if (model.getUserAccount().equals("zhangxi") && model.getUserPassword().equals("123")) {
                model.setResultText("欢迎 zhangxi");
            } else {
                model.setResultText("ERROR!! ");
            }
            getData().postValue(model);
        }
    }

    public void doClickCancelImgBtn() {
        UserModel model = getData().getValue();
        if (model != null) {
            model.setUserAccount("");
            model.setIsShowImageBtn(false);
            getData().postValue(model);
        }
    }
}

