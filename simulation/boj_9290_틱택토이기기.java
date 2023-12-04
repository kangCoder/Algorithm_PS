package simulation;

import java.io.*;

public class boj_9290_틱택토이기기 {

    static char[][] board = new char[3][3];

    static void solve(int i, int j, char c) {
        if (i == 0 && j == 0) {
            //가로
            if (board[i][j + 1] == c) {
                board[i][j + 2] = c;
                return;
            } else if (board[i][j + 2] == c) {
                board[i][j + 1] = c;
                return;
            }

            //세로
            if (board[i + 1][j] == c) {
                board[i + 2][j] = c;
                return;
            } else if (board[i + 2][j] == c) {
                board[i + 1][j] = c;
                return;
            }

            //대각
            if (board[i + 1][j + 1] == c) {
                board[i + 2][j + 2] = c;
            } else if (board[i + 2][j + 2] == c) {
                board[i + 1][j + 1] = c;
            }
        } else if (i == 1 && j == 0) {
            //가로
            if (board[i][j + 1] == c) {
                board[i][j + 2] = c;
                return;
            } else if (board[i][j + 2] == c) {
                board[i][j + 1] = c;
                return;
            }

            //세로
            if (board[i - 1][j] == c) {
                board[i + 1][j] = c;
            } else if (board[i + 1][j] == c) {
                board[i - 1][j] = c;
            }
        } else if (i == 2 && j == 0) {
            //가로
            if (board[i][j + 1] == c) {
                board[i][j + 2] = c;
                return;
            } else if (board[i][j + 2] == c) {
                board[i][j + 1] = c;
                return;
            }

            //세로
            if (board[i - 1][j] == c) {
                board[i - 2][j] = c;
                return;
            } else if (board[i - 2][j] == c) {
                board[i - 1][j] = c;
                return;
            }

            //대각
            if (board[i - 1][j + 1] == c) {
                board[i - 2][j + 2] = c;
            } else if (board[i - 2][j + 2] == c) {
                board[i - 1][j + 1] = c;
            }
        } else if (i == 0 && j == 1) {
            //가로
            if (board[i][j - 1] == c) {
                board[i][j + 1] = c;
                return;
            } else if (board[i][j + 1] == c) {
                board[i][j - 1] = c;
                return;
            }

            //세로
            if (board[i + 1][j] == c) {
                board[i + 2][j] = c;
            } else if (board[i + 2][j] == c) {
                board[i + 1][j] = c;
            }
        } else if (i == 1 && j == 1) {
            //가로
            if (board[i][j + 1] == c) {
                board[i][j - 1] = c;
                return;
            } else if (board[i][j - 1] == c) {
                board[i][j + 1] = c;
                return;
            }

            //세로
            if (board[i - 1][j] == c) {
                board[i + 1][j] = c;
                return;
            } else if (board[i + 1][j] == c) {
                board[i - 1][j] = c;
                return;
            }

            //대각
            if (board[i - 1][j - 1] == c) {
                board[i + 1][j + 1] = c;
            } else if (board[i + 1][j + 1] == c) {
                board[i - 1][j - 1] = c;
            }
        } else if (i == 2 && j == 1) {
            //가로
            if (board[i][j - 1] == c) {
                board[i][j + 1] = c;
                return;
            } else if (board[i][j + 1] == c) {
                board[i][j - 1] = c;
                return;
            }

            //세로
            if (board[i - 1][j] == c) {
                board[i - 2][j] = c;
            } else if (board[i - 2][j] == c) {
                board[i - 1][j] = c;
            }
        } else if (i == 0 && j == 2) {
            //가로
            if (board[i][j - 1] == c) {
                board[i][j - 2] = c;
                return;
            } else if (board[i][j - 2] == c) {
                board[i][j - 1] = c;
                return;
            }

            //세로
            if (board[i + 1][j] == c) {
                board[i + 2][j] = c;
                return;
            } else if (board[i + 2][j] == c) {
                board[i + 1][j] = c;
                return;
            }

            //대각
            if (board[i + 1][j - 1] == c) {
                board[i + 2][j - 2] = c;
            } else if (board[i + 2][j - 2] == c) {
                board[i + 1][j - 1] = c;
            }
        } else if (i == 1 && j == 2) {
            //가로
            if (board[i][j - 1] == c) {
                board[i][j - 2] = c;
                return;
            } else if (board[i][j - 2] == c) {
                board[i][j - 1] = c;
                return;
            }

            //세로
            if (board[i + 1][j] == c) {
                board[i - 1][j] = c;
            } else if (board[i - 1][j] == c) {
                board[i + 1][j] = c;
            }
        } else if (i == 2 && j == 2) {
            //가로
            if (board[i][j - 1] == c) {
                board[i][j - 2] = c;
                return;
            } else if (board[i][j - 2] == c) {
                board[i][j - 1] = c;
                return;
            }

            //세로
            if (board[i - 1][j] == c) {
                board[i - 2][j] = c;
                return;
            } else if (board[i - 2][j] == c) {
                board[i - 1][j] = c;
                return;
            }

            //대각
            if (board[i - 1][j - 1] == c) {
                board[i - 2][j - 2] = c;
            } else if (board[i - 2][j - 2] == c) {
                board[i - 1][j - 1] = c;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            for (int i = 0; i < 3; i++) {
                String s = br.readLine();
                for (int j = 0; j < 3; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            char c = br.readLine().charAt(0);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == c) {
                        solve(i, j, c);
                    }
                }
            }

            System.out.println("Case " + tc + ":");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }
}
