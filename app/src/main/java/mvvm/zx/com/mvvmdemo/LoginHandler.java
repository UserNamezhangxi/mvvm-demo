package mvvm.zx.com.mvvmdemo;

import android.view.View;

public class LoginHandler {

    private LoginViewModel viewModel;

    public LoginHandler(LoginViewModel loginViewModel) {
        this.viewModel = loginViewModel;
    }

    public void clickLoginBtn(View view) {
        viewModel.doClickEvent();
    }

    public void clickClearImgBtn(View view) {
        viewModel.doClickCancelImgBtn();
    }

}
