package com.spring.msadmin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Abraham
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MsOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String pid;

    private Integer spend;

    private LocalDateTime created;

    private LocalDateTime updated;

    private Integer deleted;

    public MsOrder(String name, String pid, Integer spend) {
        this.name = name;
        this.pid = pid;
        this.spend = spend;
    }

    public MsOrder() {
        super();
    }
}
