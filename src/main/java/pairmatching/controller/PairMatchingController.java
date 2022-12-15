package pairmatching.controller;

import pairmatching.DTO.MenuDTO;
import pairmatching.DTO.PairTagDTO;
import pairmatching.DTO.RematchingDTO;
import pairmatching.domain.Matching;
import pairmatching.domain.PairRepository;
import pairmatching.domain.PairTag;
import pairmatching.view.ExceptionHandler;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

    private final PairRepository pairRepository = new PairRepository();
    private PairTag pairTag;

    public void run() {
        // 메뉴 출력
        MenuDTO menuDTO;
        do {
            menuDTO = ExceptionHandler.input(InputView::readMenu);
            menuDTO.getMenu().process(this);
        } while (!menuDTO.getMenu().isQuit());
    }

    public void pairMatch() {
        OutputView.printPairMatchingInformation();
        match();
    }

    public void match() {
        // 페어태그를 입력받는다
        PairTagDTO pairMatchingDTO = ExceptionHandler.input(InputView::readPairTag);
        pairTag = pairMatchingDTO.getPairTag();
        // 해당 페어태그의 패어매칭이 이미 이루어졌는지 확인한다.
        if (pairRepository.isAlreadyPaired(pairTag)) {
            // 이미 페어매칭이 이루어졌으면 재매칭 여부를 입력받아 시행한다.
            RematchingDTO rematchingDTO = ExceptionHandler.input(InputView::readRematching);
            rematchingDTO.getRematching().process(this);
            return;
        }
        // 안이루어졌으면 페어매칭을 진행하고 결과를 출력한다.
        pairRepository.pairMatching(pairTag);
        printMatching();
    }

    public void rematch() {
        pairRepository.reset(pairTag);
        pairRepository.pairMatching(pairTag);
        printMatching();
    }

    public void lookUpPairMatching() {
        OutputView.printPairMatchingInformation();
        PairTagDTO pairMatchingDTO = ExceptionHandler.input(InputView::readPairTag);
        pairTag = pairMatchingDTO.getPairTag();
        printMatching();
    }

    public void resetPairMatching() {
        pairRepository.resetAll();
        OutputView.printResetNotice();
    }

    private void printMatching() {
        Matching matching = pairRepository.getMatching(pairTag);
        if (matching.isEmpty()) {
            OutputView.printNoMatchingRecord();
            return;
        }
        OutputView.printMatching(matching);
    }
}