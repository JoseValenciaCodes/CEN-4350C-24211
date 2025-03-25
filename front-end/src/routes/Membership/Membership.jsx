/** Code of Membership Page */
// Use Hooks
import { useState, useEffect } from "react";

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
    fetchMemberships();
  }, []);

  return (
    <MembershipContainer>
        <MembershipHero />
        <MembershipCardContainer>
            {
                (loading) ? <p>Loading...</p>
                :((error) ? <p>Error: {error}</p>: (
                    memberships.map(membership => (
                        <MembershipCard 
                            title={membership.title}
                            description={membership.description}
                            price={membership.price}
                            key={membership.id}
                        />
                    ))
                ))  
            }
        </MembershipCardContainer>
    </MembershipContainer>
  );
}

export default Membership;
