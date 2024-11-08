import Home from "./Home/Home";
import AddProduct from "./Add/AddProduct";
import ViewProduct from "./View/ViewProducts";
import EditProduct from "./Edit/EditProduct";
import {Route, Routes} from 'react-router-dom';

const Master = () => {
    return (
        <Routes>
            <Route path="/" element={<Home />} ></Route>
            <Route path="/addProduct" element={<AddProduct />} ></Route>
            <Route path="/viewProducts" element={<ViewProduct />} ></Route>
            <Route path="/editProduct/:pid" element={<EditProduct />} ></Route>
        </Routes>
    )
}

export default Master;