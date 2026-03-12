package br.com.dio;

import br.com.dio.dto.UserDTO;
import br.com.dio.mapper.UserMapper;
import br.com.dio.model.UserModel;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {
    private static final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public static void main(String[] args) {
        var model = new UserModel();
        model.setCode(1);
        model.setUsername("Vicent");
        model.setBirthDate(LocalDate.now().minusYears(30));
        System.out.println(mapper.toDTO(model));

        var dto = new UserDTO();
        dto.setId(1);
        dto.setName("Maria");
        dto.setBirthDate(LocalDate.now().minusYears(30));
        System.out.println(mapper.toModel(dto));
    }
}
