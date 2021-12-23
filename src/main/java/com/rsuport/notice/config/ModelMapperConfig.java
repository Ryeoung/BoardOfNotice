package com.rsuport.notice.config;

import com.rsuport.notice.domain.Board;
import com.rsuport.notice.dto.ReadBoardDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    /**
     * @return ModelMapper
     * Entity -> dto or Dto -> entity 변환할 model Mapper 반환
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
