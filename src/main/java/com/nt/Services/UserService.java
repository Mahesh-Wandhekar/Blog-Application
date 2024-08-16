package com.nt.Services;

import com.nt.Binding.RegisterBinding;

public interface UserService {
	
	public boolean register(RegisterBinding binding);
	public boolean login(RegisterBinding binding);

}
