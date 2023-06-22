package uz.pdp.warehousebigproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.warehousebigproject.entity.User;
import uz.pdp.warehousebigproject.payload.Result;
import uz.pdp.warehousebigproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    //CREATE
    public Result addUser(User user) {
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber()))
            return new Result("bunday phoneNUmber li user mavjud", false);

        userRepository.save(user);
        return new Result("saqlandi ", true);
    }

    //READ
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    //UPDATE
    public Result updateUser(Integer userId, User user) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent())
            return new Result("bunday id li user topilmadi ", false);

        User editedUser = optionalUser.get();
        editedUser.setActive(true);
        editedUser.setCode("1");
        editedUser.setPassword(user.getPassword());
        editedUser.setFirstName(user.getFirstName());
        editedUser.setLastName(user.getLastName());
        userRepository.save(editedUser);

        return new Result("updated", true);


    }

    //DELETE
    public Result deleteUser(Integer userId) {
        try{
            userRepository.deleteById(userId);
        }catch (Exception e){
            e.printStackTrace();
            return new Result("error" , false);
        }
        return new Result("error" , false);
    }
}
