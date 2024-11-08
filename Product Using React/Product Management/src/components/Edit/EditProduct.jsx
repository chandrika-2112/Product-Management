import axios from "axios";
import "./Edit.css"
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const EditProduct = () => {

    const { pid } = useParams();
    const [product, setProduct] = useState({
        pid:'',
        name:'',
        image:'',
        costPrice:'',
        quantity:'',
        origin:''
    })

    const navigate = useNavigate();

    useEffect(() => {
        axios.get(`http://localhost:9000/product/${pid}`).then((posRes) => {
            setProduct(posRes.data);
        }, (errRes) => {
            console.log(errRes);
        })
    }, [pid]);

    const handleChange = (e) => {
        const {name, value} = e.target;
        setProduct({...product, [name]: value});
    }

    const handleEdit = () => {
        axios.put(`http://localhost:9000/update/${pid}`, {
            ...product,
            pid:parseInt(product.pid),
            origin:product.origin
        })
        // eslint-disable-next-line no-unused-vars
        .then((posRes) => {
            navigate("/viewProducts");
        }, (errRes) => {
            console.log(errRes);
        })
    }

    const view_product = () => {
        navigate("/viewProducts");
    }

    return(
        <div className="container">
            <h2>Edit Product Details</h2>
            <fieldset>
                <legend>Edit Product</legend>
                <input type="number" name="pid" value={product.pid} onChange={handleChange} disabled/> <br></br><br></br>
                <input type="text" name="name" value={product.name} onChange={handleChange} /> <br></br><br></br>
                <input type="text" name="image" value={product.image} onChange={handleChange} /> <br></br><br></br>
                <input type="number" name="costPrice" value={product.costPrice} onChange={handleChange} /> <br></br><br></br>
                <input type="number" name="quantity" value={product.quantity} onChange={handleChange} /> <br></br><br></br>
                <input type="text" name="origin" value={product.origin} onChange={handleChange} /> <br></br><br></br>
                <button type="submit"  onClick={handleEdit}>Update</button><br></br>
            </fieldset>

            <button className="button" onClick={view_product}> Back</button>
        </div>
    )

}

export default EditProduct;