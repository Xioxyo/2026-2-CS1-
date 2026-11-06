import sqlite3


class RepositorioPedidos:
    def __init__(self, db_path=":memory:"):
        self.db_path = db_path
        self.conn = sqlite3.connect(self.db_path)
        self._crear_tabla()

    def _crear_tabla(self):
        self.conn.execute("""
            CREATE TABLE IF NOT EXISTS pedidos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                cliente TEXT NOT NULL,
                total REAL NOT NULL,
                estado TEXT DEFAULT 'pendiente'
            )
        """)
        self.conn.commit()

    def guardar(self, cliente, total):
        cursor = self.conn.execute(
            "INSERT INTO pedidos (cliente, total) VALUES (?, ?)",
            (cliente, total)
        )
        self.conn.commit()
        return cursor.lastrowid

    def obtener(self, pedido_id):
        row = self.conn.execute(
            "SELECT id, cliente, total, estado FROM pedidos WHERE id = ?",
            (pedido_id,)
        ).fetchone()
        return row