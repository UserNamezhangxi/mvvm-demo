package mvvm.zx.com.mvvmdemo;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mvvm.zx.com.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final LoginViewModel viewModel = new LoginViewModel(getApplication());
        binding.setLifecycleOwner(this);
        binding.setLoginViewModel(viewModel);
        binding.setLoginHandler(new LoginHandler(viewModel));
        binding.setUserModel(viewModel.getData().getValue());

        viewModel.getData().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(@Nullable UserModel model) {
                if (model != null) {
                    binding.setUserModel(model);
                }
            }
        });
    }
}
