package com.example.pizza.converters;


import com.example.pizza.model.Size;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SizeCommandToSize implements Converter<com.example.pizza.commands.SizeCommand, Size> {

    @Synchronized
    @Nullable
    @Override
    public Size convert(com.example.pizza.commands.SizeCommand source) {
        if (source == null) {
            return null;
        }

        final Size size = new Size();
        size.setPrice(source.getPrice());


        return size;
    }
}