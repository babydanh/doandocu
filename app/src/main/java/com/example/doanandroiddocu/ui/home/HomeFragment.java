package com.example.doanandroiddocu.ui.home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.doanandroiddocu.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    ImageView imggiadung, imgDienTu, imgThoiTrang, imgXeCo;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Lấy các thành phần từ layout
        EditText edtTimKiem = binding.edtTimKiem;
        ImageView imggiadung = binding.imggiadung;
        ImageView imgDienTu = binding.imgdientu;
        ImageView imgThoiTrang = binding.imgthoitrang;
        ImageView imgXeCo = binding.imgxeco;

        // Xử lý sự kiện tìm kiếm khi nhập dữ liệu
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Gọi hàm tìm kiếm sản phẩm
                searchProduct(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Xử lý click vào danh mục sản phẩm
        imggiadung.setOnClickListener(v -> showCategory("Đồ gia dụng"));
        imgDienTu.setOnClickListener(v -> showCategory("Đồ điện tử"));
        imgThoiTrang.setOnClickListener(v -> showCategory("Thời trang"));
        imgXeCo.setOnClickListener(v -> showCategory("Xe cộ"));

        return root;

        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/
    }

    // Hàm xử lý tìm kiếm sản phẩm (Giả lập)
    private void searchProduct(String query) {
        if (!query.isEmpty()) {
            Toast.makeText(getContext(), "Tìm kiếm: " + query, Toast.LENGTH_SHORT).show();
        }
    }

    // Hàm xử lý chọn danh mục
    private void showCategory(String category) {
        Toast.makeText(getContext(), "Bạn chọn danh mục: " + category, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}