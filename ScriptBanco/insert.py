
from models import Restaurantes, Usuarios, Lanches, Pedidos
from main import session

def insert_restaurante():

    restaurantes = Restaurantes (
        name = "Restaurante do Keven",
        email = "jurema@gmail.com",
        senha = "jurema123",
        cnpj = "00000-0000",
        endereco = "rua das horquideos",
        num = 900,
        cep = 909090,
        lanches = [
            Lanches(name = "X-Salada", price = 5.87,description = "Tem sala e cheddar"),
            Lanches(name = "X-Burguer", price = 7.80,description = "Tem sala e cheddar"),
        ]
    )

    session.add_all([restaurantes])

    session.commit()
    

def insert_cliente():

    clientes = Usuarios (
        name = "Claudia Maria",
        email = "claudia_maria@gmail.com",
        senha = "claudia123",
        cpf = "00000-0000",
        endereco = "rua das montanhas",
        num = 590,
        cep = 234521,
    )

    session.add_all([clientes])

    session.commit()


def insert_pedido():

    pedidos = Pedidos (
        idUsuario = 1,
        idRestaurante = 1,
        idLanche = 2,
        totalPrice = Lanches.price
    )

    session.add_all([pedidos])

    session.commit()
    
    
insert_restaurante()