package com.github.morinb.roster;

import java.io.Serializable;

public interface ColumnModel extends Serializable {
    String getHeaderName();

    String getField();
}
