package production;

public interface IModel {
    void setFieldState(int row, int column, EFieldState fieldstate);

    EFieldState getFieldState(int row, int column);

	String toServerString();
}
