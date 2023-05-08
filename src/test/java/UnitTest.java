import br.com.fabiano.application.GameFrame;
import br.com.fabiano.domain.Node;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;

import static br.com.fabiano.domain.logic.Game.startGame;
import static org.mockito.Mockito.*;

public class UnitTest {
    @BeforeClass
    public static void setUp() {
        mockStatic(JOptionPane.class);
    }

    @Test
    public void testStartGameWithOneNode() {
        GameFrame gameFrame = mock(GameFrame.class);
        Node node = mock(Node.class);
        Node unusableNode = mock(Node.class);

        when(JOptionPane.showConfirmDialog(gameFrame, node.getQuestion(), "Confirm", JOptionPane.YES_NO_OPTION))
                .thenReturn(JOptionPane.YES_OPTION);
        startGame(gameFrame, node);

        verify(node, atLeastOnce()).getQuestion();
        verify(node, atLeast(0)).getLeft();
        verify(unusableNode, atLeast(0)).getQuestion();
    }

    @Test
    public void testStartGameWithTwoItemNode() {
        GameFrame gameFrame = mock(GameFrame.class);
        Node node = mock(Node.class);
        Node leftNode = mock(Node.class);

        when(node.getQuestion()).thenReturn("É uma massa?");
        when(node.getLeft()).thenReturn(leftNode);

        when(JOptionPane.showConfirmDialog(gameFrame, node.getQuestion(), "Confirm", JOptionPane.YES_NO_OPTION))
                .thenReturn(JOptionPane.YES_OPTION);

        startGame(gameFrame, node);

        verify(node, atLeastOnce()).getQuestion();
        verify(node, atLeast(0)).getRight();
        verify(leftNode, atLeastOnce()).getQuestion();
    }

    @Test
    public void testStartGameWithOneRightNode() {
        GameFrame gameFrame = mock(GameFrame.class);
        Node node = mock(Node.class);
        Node rightNode = mock(Node.class);

        when(node.getQuestion()).thenReturn("É uma massa?");
        when(node.getRight()).thenReturn(rightNode);

        when(JOptionPane.showConfirmDialog(gameFrame, node.getQuestion(), "Confirm", JOptionPane.YES_NO_OPTION))
                .thenReturn(JOptionPane.NO_OPTION);

        startGame(gameFrame, node);

        verify(node, atLeastOnce()).getQuestion();
        verify(node, atLeast(0)).getLeft();
        verify(rightNode, atLeastOnce()).getQuestion();
    }

}
