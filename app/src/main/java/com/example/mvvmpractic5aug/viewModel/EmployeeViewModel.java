package com.example.mvvmpractic5aug.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmpractic5aug.model.APIResponse;
import com.example.mvvmpractic5aug.repository.EmployeeRepository;

public class EmployeeViewModel extends AndroidViewModel {

   /* private LiveData<APIResponse>liveData;
    EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        employeeRepository=new EmployeeRepository();
        liveData=employeeRepository.getRepositoryCall();
    }

    public void getResponse(){

        employeeRepository.getAPICall();
    }

    public LiveData<APIResponse> getAllLiveData(){
        return liveData;
    }*/

    private LiveData<APIResponse> liveData;

    private EmployeeRepository employeeRepository;

    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }


    public void init(){
        employeeRepository=new EmployeeRepository();
        liveData=employeeRepository.getRepositoryCall();
    }


    public void getResponse(){
        employeeRepository.getAPICall();
    }

    public LiveData<APIResponse> getAllLiveData(){
        return liveData;
    }
}
