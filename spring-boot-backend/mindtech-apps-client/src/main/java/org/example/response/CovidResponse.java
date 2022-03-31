package org.example.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.dto.CovidDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Covid response class.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CovidResponse implements Serializable {

    private static final long serialVersionUID = -3660237022206644989L;

    private List<CovidDTO> covidDTO;
}
