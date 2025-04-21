/** Code of Membership Page */
// Use Hooks
import { useState, useEffect, useContext } from "react";

import { UserContext } from "../../context/UserContext";
import MembershipContainer from "../../components/MembershipContainer/MembershipContainer";
import MembershipHero from "../../components/MembershipHero/MembershipHero";
import MembershipCardContainer from "../../components/MembershipCardContainer/MembershipCardContainer";
import MembershipCard from "../../components/MembershipCard/MembershipCard";

// Import Base Client
import baseClient from "../../api/baseClient";

function Membership() {
  const [memberships, setMemberships] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const [userMembership, setUserMembership] = useState(null);

  const { user } = useContext(UserContext);

  useEffect(() => {
    const fetchMemberships = async () => {
        try
        {
            const res = await baseClient.get("/memberships");
            setMemberships(res.data);
        }
        catch (err)
        {
            setError(err.error);
        }
        finally
        {
            setLoading(false);
        }
    };

    const fetchUserMembership = async () => {
        try
        {
            const res = await baseClient.get(`/memberships/user/${user.id}`);
            setUserMembership(res.data);
        }
        catch (err)
        {
            setUserMembership(null);
        }
    };

    fetchMemberships();

    if (user.id !== undefined)
    {
        fetchUserMembership();
    }
  }, []); 

  return (
    <MembershipContainer>
        <MembershipHero />
        <MembershipCardContainer>
            {
                (loading) ? <p>Loading...</p>
                :((error) ? <p>Error: {error}</p>: (
                    memberships.map(membership => {

                        return (
                        <MembershipCard 
                            id={membership.id}
                            title={membership.title}
                            description={membership.description}
                            price={membership.price}
                            key={membership.id}
                            selected={userMembership != null ? membership.id == userMembership.id : false}
                        />
                    )}
                )
                ))  
            }
        </MembershipCardContainer>
    </MembershipContainer>
  );
}

export default Membership;
