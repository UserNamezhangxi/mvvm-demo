package mvvm.zx.com.mvvmdemo;

import android.databinding.BaseObservable;

public class UserModel extends BaseObservable {

    public String userAccount;
    public String userPassword;
    public String resultText;
    public boolean isShowImageBtn;

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public boolean getIsShowImageBtn() {
        return isShowImageBtn;
    }

    public void setIsShowImageBtn(boolean isShowImageBtn) {
        this.isShowImageBtn = isShowImageBtn;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
