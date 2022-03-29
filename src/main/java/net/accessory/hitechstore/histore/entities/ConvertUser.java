package net.accessory.hitechstore.histore.entities;

public class ConvertUser {
    public static UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFullName(user.getFullName());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setGender(user.getGender());
        userDTO.setId(user.getId());
        userDTO.setActive(user.getActive());
        userDTO.setJoinedAt(user.getJoinedAt());
        userDTO.setLastEdited(user.getLastEdited());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
