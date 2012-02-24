package lila
package model

import Pos._
import format.Visual

class PawnTest extends LilaSpec {

  "a white pawn" should {

    "move towards rank by 1 square" in {
      Board(
        A4 -> White.pawn
      ) basicMoves A4 must bePoss(A5)
    }

    "not move to positions that are occupied by the same color" in {
      Board(
        A4 -> White.pawn,
        A5 -> White.pawn
      ) basicMoves A4 must bePoss()
    }

    "capture in diagonal" in {
      Board(
        D4 -> White.pawn,
        C5 -> Black.pawn,
        E5 -> Black.bishop
      ) basicMoves D4 must bePoss(C5, D5, E5)
    }

    "require a capture to move in diagonal" in {
      Board(
        A4 -> White.pawn,
        C5 -> White.pawn
      ) basicMoves A4 must bePoss(A5)
    }
  }

  "a black pawn" should {

    "move towards rank by 1 square" in {
      Board(
        A4 -> Black.pawn
      ) basicMoves A4 must bePoss(A3)
    }

    "not move to positions that are occupied by the same color" in {
      Board(
        A4 -> Black.pawn,
        A3 -> Black.pawn
      ) basicMoves A4 must bePoss()
    }

    "capture in diagonal" in {
      Board(
        D4 -> Black.pawn,
        C3 -> White.pawn,
        E3 -> White.bishop
      ) basicMoves D4 must bePoss(C3, D3, E3)
    }

    "require a capture to move in diagonal" in {
      Board(
        A4 -> Black.pawn,
        C3 -> Black.pawn
      ) basicMoves A4 must bePoss(A3)
    }
  }
}
