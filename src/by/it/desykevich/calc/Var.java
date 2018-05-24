package by.it.desykevich.calc;


abstract class Var implements Operation {

  @Override
  public Var add(Var other) throws CalcException {
    throw new CalcException(String.format(
            "Сложение %s + %s невозможно.\n", this, other));
  }

  @Override
  public Var sub(Var other) throws CalcException {
    throw new CalcException(String.format(
            "Вычитание %s - %s невозможно.\n", this, other));
  }

  @Override
  public Var mul(Var other) throws CalcException {
    throw new CalcException(String.format(
            "Умножение %s * %s невозможно.\n", this, other));
  }

  @Override
  public Var div(Var other) throws CalcException {
    throw new CalcException(String.format(
            "Деление %s / %s невозможно.\n", this, other));
  }

  @Override
  public Var assign(Var other) throws CalcException {
    throw new CalcException(String.format(
            "Присваивание %s = %s невозможно.\n", this, other));
  }

}
