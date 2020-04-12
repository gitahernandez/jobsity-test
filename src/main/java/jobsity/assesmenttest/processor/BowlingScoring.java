package jobsity.assesmenttest.processor;

import jobsity.assesmenttest.interfaces.Scoring;
import jobsity.assesmenttest.objects.BoardDTO;
import jobsity.assesmenttest.objects.FrameDTO;
import jobsity.assesmenttest.objects.PlayerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

/**
 *
 * @author andresfelipehernandezrocha
 */
public class BowlingScoring implements Scoring {

    @Override
    public void printScore(ArrayList<PlayerDTO> playerDTOList) {
        System.out.print("Frame \t\t\t");
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(
                n -> System.out.print(n + "\t"));
        System.out.print("\n");
        playerDTOList.stream().forEach((PlayerDTO playerDTO) -> {

            System.out.println(playerDTO.getName());
            System.out.println(playerDTO.getPinFallsText());
            System.out.println(playerDTO.getScoreText());

        });
    }

    @Override
    public BoardDTO convertInputInGameInformation(Stream<String> stream) {

        BoardDTO boardDTO = new BoardDTO();
        ArrayList<PlayerDTO> playerDTOList = new ArrayList<>();

        ArrayList<FrameDTO> frameDTOList = new ArrayList<>();

        stream.forEach((String rollFromFile) -> {

            String[] rollInformation = rollFromFile.split(" ");
            String playerName;
            int pinsFall;

            playerName = rollInformation[0];
            pinsFall = Integer.parseInt(rollInformation[1]);

            PlayerDTO playerDTO = playerDTOList.stream()
                    .filter(x -> playerName.equals(x.getName()))
                    .findAny()
                    .orElse(null);

            if (playerDTO == null) {
                playerDTO = new PlayerDTO(playerName);
                playerDTOList.add(playerDTO);

                FrameDTO frameDTO = new FrameDTO(1, playerDTO, pinsFall);
                frameDTOList.add(frameDTO);
            } else {

                FrameDTO frame = frameDTOList.stream()
                        .filter(x -> playerName.equals(x.getPlayerDTO().getName()) && x.getFirstRollDTO().getType().equals("NORMAL")
                        && x.getSecondRollDTO().getType().equals("PENDING"))
                        .findAny()
                        .orElse(null);

                if (frame == null) {

                    List<FrameDTO> frameDTOList1;
                    frameDTOList1 = frameDTOList.stream()
                            .filter(x -> playerName.equals(x.getPlayerDTO().getName()))
                            .collect(Collectors.toList());

                    FrameDTO frameDTO = new FrameDTO(frameDTOList1.size() + 1, playerDTO, pinsFall);
                    frameDTOList.add(frameDTO);
                } else {

                    frame.getSecondRollDTO().setPinfalls(pinsFall);
                    if (pinsFall + frame.getFirstRollDTO().getPinfalls() == 10) {
                        frame.getSecondRollDTO().setType("SPARE");
                    } else {
                        frame.getSecondRollDTO().setType("NORMAL");
                    }

                }
            }

        });

        boardDTO.setFrames(frameDTOList);
        boardDTO.setPlayers(playerDTOList);
        return boardDTO;
    }

    @Override
    public ArrayList<PlayerDTO> calculateScoreByPlayer(ArrayList<PlayerDTO> playerDTOList, ArrayList<FrameDTO> frameDTOList) {

        playerDTOList.stream().forEach((PlayerDTO playerDTO) -> {

            ArrayList<FrameDTO> framesByPlayer = (ArrayList<FrameDTO>) frameDTOList.stream()
                    .filter(x -> playerDTO.getName().equals(x.getPlayerDTO().getName()))
                    .collect(Collectors.toList());

            String ScoreText = "", pinfalls = "";
            int nextOneScore, nextTwoScore, nextThreScore, previousScore;
            for (int i = 0; i < framesByPlayer.size(); i++) {
                if (framesByPlayer.get(i).getNumber() == 11) {
                    break;
                }
                previousScore = 0;
                nextOneScore = 0;
                nextTwoScore = 0;
                nextThreScore = 0;
                int ownScore = framesByPlayer.get(i).getFirstRollDTO().getPinfalls() + framesByPlayer.get(i).getSecondRollDTO().getPinfalls();

                if (framesByPlayer.get(i).getFirstRollDTO().getType().equals("STRIKE")) {

                    if (i == framesByPlayer.size() - 2) {
                        if (framesByPlayer.get(i + 1).getFirstRollDTO().getType().equals("STRIKE")) {
                            nextThreScore = framesByPlayer.get(i + 1).getFirstRollDTO().getPinfalls() + framesByPlayer.get(i + 1).getSecondRollDTO().getPinfalls();

                            if (framesByPlayer.get(i + 2).getFirstRollDTO().getType().equals("STRIKE")) {
                                nextThreScore = framesByPlayer.get(i + 2).getFirstRollDTO().getPinfalls() + framesByPlayer.get(i + 2).getSecondRollDTO().getPinfalls();
                            }
                        } else {
                            nextThreScore += framesByPlayer.get(i + 1).getFirstRollDTO().getPinfalls() + framesByPlayer.get(i + 1).getSecondRollDTO().getPinfalls();

                        }

                    } else {

                        if (framesByPlayer.get(i + 1).getFirstRollDTO().getType().equals("STRIKE")) {

                            nextOneScore = 10;
                            if (framesByPlayer.get(i + 2).getFirstRollDTO().getType().equals("STRIKE")) {
                                nextTwoScore = 10;
                            } else {
                                nextTwoScore = framesByPlayer.get(i + 2).getFirstRollDTO().getPinfalls();
                            }

                        } else if (framesByPlayer.get(i + 1).getSecondRollDTO().getType().equals("SPARE")) {
                            nextOneScore = 10;
                            nextTwoScore = 0;
                        } else {
                            nextOneScore = framesByPlayer.get(i + 1).getFirstRollDTO().getPinfalls();
                            nextTwoScore = framesByPlayer.get(i + 1).getSecondRollDTO().getPinfalls();
                        }

                    }
                } else if (framesByPlayer.get(i).getSecondRollDTO().getType().equals("SPARE")) {
                    nextOneScore = framesByPlayer.get(i + 1).getFirstRollDTO().getPinfalls();
                }

                if (i > 0) {
                    previousScore = framesByPlayer.get(i - 1).getScore();
                }

                framesByPlayer.get(i).setScore(ownScore + nextOneScore + nextTwoScore + previousScore + nextThreScore);

                ScoreText = ScoreText + "\t" + framesByPlayer.get(i).getScore();

                String pinfallstext, lastpin = "";
                if (framesByPlayer.get(i).getFirstRollDTO().getType().equals("STRIKE")) {
                    pinfallstext = " X";
                    if (i == 9) {
                        if (framesByPlayer.get(i + 1).getFirstRollDTO().getType().equals("STRIKE")) {
                            lastpin = " X ";
                            if (framesByPlayer.get(i + 1).getFirstRollDTO().getType().equals("STRIKE")) {
                                lastpin = " X X";
                            }

                        } else {
                            lastpin = " " + String.valueOf(framesByPlayer.get(i + 1).getFirstRollDTO().getPinfalls()) + " " + String.valueOf(framesByPlayer.get(i + 1).getSecondRollDTO().getPinfalls());
                        }
                    }
                } else if (framesByPlayer.get(i).getSecondRollDTO().getType().equals("SPARE")) {
                    pinfallstext = framesByPlayer.get(i).getFirstRollDTO().getPinfalls() + " /";
                } else {
                    pinfallstext = String.valueOf(framesByPlayer.get(i).getFirstRollDTO().getPinfalls()) + " " + String.valueOf(framesByPlayer.get(i).getSecondRollDTO().getPinfalls());
                }

                pinfalls = pinfalls + "\t" + pinfallstext + lastpin;

            }

            playerDTO.setPinFallsText("PinFalls \t" + pinfalls);
            playerDTO.setScoreText("Score \t\t" + ScoreText);

        });
        return playerDTOList;
    }

    @Override
    public boolean validateInput(Stream<String> stream) {
        try {
            String badRow = stream
                    .filter(
                            x -> x.split(" ").length != 2
                            || (Integer.parseInt(x.split(" ")[1]) < 0 || Integer.parseInt(x.split(" ")[1]) > 10)
                    )
                    .findAny()
                    .orElse(null);

            if (badRow != null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
