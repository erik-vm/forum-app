import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { styled } from '@mui/material/styles';
import { Container } from '@mui/system';
import {useNavigate} from 'react-router-dom';
import Button from '@mui/material/Button';
import Link from "./ThreadLink";
import Post from "./Post"

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'left',
    color: theme.palette.text.secondary,
  }));

export default function SubmitButtons({props}) {
  const navigate = useNavigate();
    const handleSubmit = () => {
        navigate("/" + props);
    };
  return (
    <Grid item>
    <Item >
        <Button variant="primary" type="submit" onClick={handleSubmit}>{props}</Button>
    </Item>
</Grid>
  );
}