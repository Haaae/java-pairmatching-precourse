package pairmatching.DTO;

import pairmatching.view.Enum.Rematching;

public class RematchingDTO {

    private Rematching rematching;

    public RematchingDTO() {}

    public RematchingDTO setRematchingDTO(Rematching rematching) {
        this.rematching = rematching;
        return this;
    }

    public Rematching getRematching() {
        return rematching;
    }

}
