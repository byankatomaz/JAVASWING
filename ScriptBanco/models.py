from typing import List
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column, relationship
from sqlalchemy import Text, ForeignKey, Integer, String, Float


class Base(DeclarativeBase):
    pass



class Restaurantes(Base):
    __tablename__ = 'restaurantes'
    id:Mapped[int] = mapped_column(Integer, primary_key=True, autoincrement=True)
    
    name:Mapped[str] = mapped_column(String, nullable=False)
    email:Mapped[str] = mapped_column(String, nullable=False)
    senha:Mapped[str] = mapped_column(String, nullable=False)
    cnpj:Mapped[str] = mapped_column(String, nullable=False)
    endereco:Mapped[str] = mapped_column(String, nullable=False)
    num:Mapped[int] = mapped_column(String, nullable=False)
    cep:Mapped[int] = mapped_column(String, nullable=False)

    lanches:Mapped[List["Lanches"]] =  relationship(back_populates='restaurante')

    
    def __repr__(self) -> str:
        return f'<Restaurante {self.name}>'
    


class Usuarios(Base):
    __tablename__ = 'usuarios'
    id:Mapped[int] = mapped_column(primary_key=True)

    name:Mapped[str] = mapped_column(Text, nullable=False)
    email:Mapped[str] = mapped_column(Text, nullable=False)
    senha:Mapped[str] = mapped_column(Text, nullable=False)
    cpf:Mapped[str] = mapped_column(Text, nullable=False)
    endereco:Mapped[str] = mapped_column(Text, nullable=False)
    num:Mapped[int] = mapped_column(Text, nullable=False)
    cep:Mapped[int] = mapped_column(Text, nullable=False)
    
    # aplicativo:Mapped["Aplicativo"] =  relationship(back_populates='usuario')
    # pedido:Mapped["Pedidos"] =  relationship(back_populates='usuario')
    
    def __repr__(self) -> str:
        return f'<Cliente {self.name}>'


class Lanches(Base):
    __tablename__ = 'lanches'
    id:Mapped[int] = mapped_column(Integer, primary_key=True, autoincrement=True)
    
    idRestaurante:Mapped[int] = mapped_column(ForeignKey('restaurantes.id'), nullable=False)
    
    name:Mapped[str] = mapped_column(String, nullable=False)
    description:Mapped[str] = mapped_column(String, nullable=False)
    price:Mapped[float] = mapped_column(Float, nullable=False)
    
    restaurante:Mapped["Restaurantes"] =  relationship(back_populates='lanches')

    
    def __repr__(self) -> str:
        return f'<Lache ={self.name} '




class Pedidos(Base):
    __tablename__ = 'pedidos'
    id:Mapped[int] = mapped_column(primary_key=True)
    
    idUsuario:Mapped[int] = mapped_column(ForeignKey('usuarios.id'), nullable=False)
    
    idRestaurante:Mapped[int] = mapped_column(ForeignKey('restaurantes.id'), nullable=False)
    
    idLanche:Mapped[int] = mapped_column(ForeignKey('lanches.id'), nullable=False)
    
    quant:Mapped[int] = mapped_column(Integer, nullable=False)
    
    totalPrice:Mapped[float] = mapped_column(nullable=False)
    

   
    def __repr__(self) -> str:
        return f'<Lanche: {self.lanches.name} do cliente: {self.usuario.name} para o restaurante {self.restaurante.name}>'


