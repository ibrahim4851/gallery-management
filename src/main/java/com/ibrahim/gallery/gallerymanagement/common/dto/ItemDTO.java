package com.ibrahim.gallery.gallerymanagement.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ItemDTO implements Serializable, Comparable<ItemDTO> {

    @Serial
    private static final long serialVersionUID = 5713395393413002205L;

    private Long id;

    private String text;

    private String value;

    @Override
    public int compareTo(ItemDTO o) {
        return this.id.compareTo(o.getId());
    }
}
