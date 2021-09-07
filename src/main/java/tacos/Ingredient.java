package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 描述了配料所需的属性
 * @author wayne
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
