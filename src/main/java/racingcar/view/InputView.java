package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String LENGTH_ERROR = "이름은 5자 이하만 가능합니다.";
    private static final String IS_NOT_NUMBER = "숫자를 입력해 주세요.";
    private static final String IS_NOT_NATURAL_NUMBER = "전진횟수는 자연수여야 합니다.";
    private static final Character ZERO = '0';
    private static final Character NINE = '9';
    public String[] inputPlayers() {
        String players = Console.readLine();
        return splitCommaAndValidate(players);
    }

    public int inputTimes() {
        String times = Console.readLine();
        validateNumber(times);
        return isNaturalNumber(times);
    }

    private int isNaturalNumber(String times) {
        int maxForward = Integer.parseInt(times);
        if (maxForward == 0) {
            throw new IllegalArgumentException(IS_NOT_NATURAL_NUMBER);
        }
        return maxForward;
    }

    private void validateNumber(String times) {
        for (int i = 0; i < times.length(); i++) {
            char num = times.charAt(i);
            if (num < ZERO || NINE < num) {
                throw new IllegalArgumentException(IS_NOT_NUMBER);
            }
        }
    }

    private void validateNames(String[] players) {
        nameLengthValidation(players);
    }

    private String[] splitCommaAndValidate(String players) {
        String[] separatedPlayers = players.split(",");
        validateNames(separatedPlayers);
        return separatedPlayers;
    }

    private void nameLengthValidation(String[] players) {
        for (String player : players) {
            if (player.length() > 5) {
                throw new IllegalArgumentException(LENGTH_ERROR);
            }
        }
    }
}
