package com.app.vn.common.model;


import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.inject.Named;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
public class PaggingResult {
    private long firstPage;
    private long lastPage;
    private long totalPage;
    private long totalItem;
    private List itemList;
}
